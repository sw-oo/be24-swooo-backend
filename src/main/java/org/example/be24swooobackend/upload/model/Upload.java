package org.example.be24swooobackend.upload.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.be24swooobackend.feed.model.Feed;

@Entity
@Builder
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Upload {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="feed_idx")
    private Feed feed;
}
