package com.hy.reggie.controller;

import com.hy.reggie.commen.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件的上传和下载
 */

@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${reggie.path}")
    private String basePath;

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) {
        //file是一个临时文件，需要转存到指定位置，否则本次请求完成后临时文件会删除
        log.info("文件上传：{}", file.toString());

        //使用UUID重新生成文件名称，防止重复名造成文件覆盖
        try {
            file.transferTo(new File(basePath + file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
