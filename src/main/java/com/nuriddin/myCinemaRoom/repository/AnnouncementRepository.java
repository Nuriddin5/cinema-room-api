package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Announcement;
import com.nuriddin.myCinemaRoom.projection.AnnouncementView;
import com.nuriddin.myCinemaRoom.projection.ViewAnnouncements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "announcement", collectionResourceRel = "announcementList")
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    @Query(value = "select a.id as announcementId,\n" +
                   "       m.title as title,\n" +
                   "       m.poster_img_id as posterImgId,\n" +
                   "mc.movie_contract_status as status\n" +
                   "       from announcement a\n" +
                   "join movie_contract mc on mc.id = a.movie_contract_id\n" +
                   "join movie m on mc.movie_id = m.id\n" +
                   "where mc.movie_contract_status <> 'DISABLED'",
            nativeQuery = true)
    public List<ViewAnnouncements> getAllAnnouncements();

    @Query(value = "select a.id                     as announcementId,\n" +
                   "       m.name,\n" +
                   "       m.title                  as title,\n" +
                   "       m.poster_img_id          as posterImgId,\n" +
                   "       m.description,\n" +
                   "       m.duration,\n" +
                   "       m.genre,\n" +
                   "       m.age_rate as AgeRate,\n" +
                   "       m.year,\n" +
                   "       m.trailer_link as trailerLink,\n" +
                   "       a.created_at as createdAt,\n" +
                   "       mc.movie_contract_status as status\n" +
                   "\n" +
                   "from announcement a\n" +
                   "         join movie_contract mc on mc.id = a.movie_contract_id\n" +
                   "         join movie m on mc.movie_id = m.id\n" +
                   "where mc.movie_contract_status = 'ACTIVE' and a.id =:Id",
            nativeQuery = true)
    Optional<AnnouncementView> getAnnouncement(Long Id);
}
