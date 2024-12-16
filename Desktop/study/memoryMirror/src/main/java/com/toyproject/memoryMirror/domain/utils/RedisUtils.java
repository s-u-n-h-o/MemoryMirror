package com.toyproject.memoryMirror.domain.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toyproject.memoryMirror.domain.model.album.AlbumDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisUtils {
    private final RedisTemplate<String, String> redisTemplate;
    private final RedisTemplate<String, Object> redisTemplateObject;
    private final StringRedisTemplate stringRedisTemplate;

    public void countAlbumViews(Long albumId) {
        String key = getKey(albumId);
        Long result = redisTemplate.opsForValue().increment(key, 1);
    }

    public Long getCountAlbumViews(Long albumId) {
        Long count = 0L;
        String key = getKey(albumId);
        boolean exist = redisTemplate.hasKey(key);

        //key값이 있는경우
        if (exist) {
            count = Long.valueOf(String.valueOf(stringRedisTemplate.opsForValue().get(key)));
        }
        return count;
    }

    public List<AlbumDetail> getRedisToAlbumDetails(Long albumId) {
        String key = getDetailKey(albumId);
        ObjectMapper objectMapper = new ObjectMapper();
        List<AlbumDetail> albumDetails = objectMapper.convertValue(redisTemplateObject.opsForValue().get(key), new TypeReference<>() {}); //역직렬화
        return albumDetails;
    }

    public void saveAlbumDetailToRedis(List<AlbumDetail> albumDetails, Long albumId) {
        String key = getDetailKey(albumId);
        redisTemplateObject.opsForValue().set(key, albumDetails); //redis에 앨범 상세정보 저장
        redisTemplateObject.expire(key, Duration.ofDays(2));
        redisTemplate.expire(getKey(albumId),Duration.ofDays(2));
    }

    public static String getKey(Long albumId) {
        return "album:views:" + albumId;
    }

    public static String getDetailKey(Long albumId) {
        return "albumDetails:" + albumId;
    }
}
