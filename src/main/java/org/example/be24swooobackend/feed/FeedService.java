package org.example.be24swooobackend.feed;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FeedService {
    private final FeedRepository feedRepository;
}
