package com.toyproject.memoryMirror.domain.utils;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class S3Utils {

    @Value("${cloud.aws.s3.bucketName}")
    private String bucketName; //@Value 어노테이션 사용시 final을 지워야 주입이 가능하다.

    @Value("${cloud.aws.region.static}")
    private String region;

    private final HttpSession httpSession;

    private final AmazonS3 amazonS3;

    /***
     * 단일 이미지 업로드
     * @param multipartFile
     * @return
     */
    public String fileUpload(MultipartFile multipartFile) throws IOException {
        // 디렉토리생성 (날짜/유저시퀀스/파일명)
        String fileName = multipartFile.getOriginalFilename() + String.valueOf(UUID.randomUUID());
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String directory = date + "/" + httpSession.getAttribute("userSequenceId") + "/" + fileName;

        //파일 업로드
        /*
        * ObjectMetadata : Amazon S3에 업로드되는 파일 또는 객체와 관련된 정보를 포함(파일크기,버전 등등)
        * */
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(multipartFile.getSize());
        objectMetadata.setContentType(multipartFile.getContentType()); //이미지 파일을 업로드할때 설정

        /***
         * public PutObjectResult putObject(
         *                                  String bucketName, 버킷 명
         *                                  String key,
         *                                  InputStream input,
         *                                  ObjectMetadata metadata 파일 객체 관련 정보들
         *                                  )
         */
        amazonS3.putObject(new PutObjectRequest(bucketName, directory, multipartFile.getInputStream(), objectMetadata));

        //s3에 저장한 이미지의 url을 내부 DB에 저장하기 위해서 조회
        String url = String.valueOf(amazonS3.getUrl(bucketName, directory));

        return url;
    }

    /***
     * 다중 이미지 업로드
     * @param multipartFiles List타입으로 저장된 이미지파일
     * @return
     */
    public List<String> filesUpload(MultipartFile[] multipartFiles) throws IOException {
        List<String> urlList = new ArrayList<>();
        for (MultipartFile file: multipartFiles) {
            String url = fileUpload(file);
            urlList.add(url);
        }
        return urlList;
    }

    /***
     * S3 파일 삭제 함수
     * @param preFileName
     */
    public void filesDelete(String preFileName) {
        String replace = "https://" + bucketName + ".s3." + region + ".amazonaws.com/";
        String fileName = preFileName.replace(replace, "");
        try {
            amazonS3.deleteObject(new DeleteObjectRequest(bucketName, fileName));
        }catch (AmazonS3Exception e) {
            log.info("파일 업로드 실패 : {}", e.getMessage());
        }
    }

    public void filesDelete(List<String> filesUrlList) {
        for(String fileUrl: filesUrlList) {
            log.info(fileUrl);
            filesDelete(fileUrl);
        }
    }
}
