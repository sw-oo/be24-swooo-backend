package org.example.be24swooobackend.upload;


import io.awspring.cloud.s3.S3Operations;
import io.awspring.cloud.s3.S3Resource;
import lombok.RequiredArgsConstructor;
import org.example.be24swooobackend.upload.model.Upload;
import org.example.be24swooobackend.upload.model.UploadDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CloudUploadService {
    private final UploadRepository uploadRepository;

    @Value("${spring.cloud.aws.s3.bucket}")
    private String s3BucketName;
    private final S3Operations s3Operations;

    public String saveFile(MultipartFile file) throws SQLException, IOException {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        String filePath = date + "/" + UUID.randomUUID() + "_" +file.getOriginalFilename();
        S3Resource s3Resource = s3Operations.upload(s3BucketName, filePath, file.getInputStream());
        return s3Resource.getURL().toString();
    }

    public List<UploadDto.UploadRes> upload(List<MultipartFile> fileList) {
        List<UploadDto.UploadRes> resList = new ArrayList<>();

        try{
            for(MultipartFile file : fileList) {
                String uploadPath = saveFile(file);
                Upload upload = uploadRepository.save(Upload.builder().imageUrl(uploadPath).build());
                resList.add(UploadDto.UploadRes.from(upload));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resList;
    }
}