package org.example.be24swooobackend.feed;


import lombok.RequiredArgsConstructor;
import org.example.be24swooobackend.feed.model.FeedDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/feed")
@RequiredArgsConstructor
@RestController
public class FeedController {
    private final FeedService feedService;

}
