package com.nuriddin.myCinemaRoom.common;

import com.nuriddin.myCinemaRoom.entity.Row;
import com.nuriddin.myCinemaRoom.entity.Seat;
import com.nuriddin.myCinemaRoom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Value("never")
    String initMode;


//    @Autowired
//    CastRepository castRepository;

//    @Autowired
//    HallRepository hallRepository;

    @Autowired
    TheatreRepository theatreRepository;


//    @Autowired
//    AttachmentRepository attachmentRepository;

    @Autowired
    RowRepository rowRepository;

    @Autowired
    SeatRepository seatRepository;

//    @Autowired
//    PriceCategoryRepository priceCategoryRepo;

    @Autowired
    MovieRepository movieRepository;


    @Override
    public void run(String... args) throws Exception {
//        if (initMode.equals("always")) {
//
//            // ZALLARNI DBGA QO'SHISH
//            List<Hall> hallList = new ArrayList<>(Arrays.asList(
//                    new Hall("Zal 1"),
//                    new Hall("Zal 2", 5.0),
//                    new Hall("Zal 3"),
//                    new Hall("Zal 4")
//            ));
//            hallRepository.saveAll(hallList);
//
//
//            //PRICE CATEGORIES DBGA QO'SHISH
////            PriceCategory cat1 = new PriceCategory("KATEGORIYA 1", 10.0, "#FF2244");
//            PriceCategory cat1 = priceCategoryRepo.save(new PriceCategory("KATEGORIYA 1", 10.0, "#FF2244"));
//            PriceCategory cat2 = priceCategoryRepo.save(new PriceCategory("KATEGORIYA 2", 8.0, "#AA0033"));
//
//            // JOYLARNI DBGA QO'SHISH (QATORLARINI HAM BIRGALIKDA)
//
//
//            Hall hall1 = hallRepository.findByName("Zal 1");
//            Hall hall2 = hallRepository.findByName("Zal 2");
//
//            Row row1 = rowRepository.save(new Row(1, hall1));
//            Row row2 = rowRepository.save(new Row(2, hall1));
//            Row row3 = rowRepository.save(new Row(3, hall1));
//            Row row12 = rowRepository.save(new Row(1, hall2));
//
//            List<Seat> seatList = new ArrayList<>(Arrays.asList(
//                    new Seat(1, row1, cat2),
//                    new Seat(2, row1, cat2),
//                    new Seat(3, row1, cat2),
//                    new Seat(4, row1, cat1),
//                    new Seat(5, row1, cat1),
//                    new Seat(6, row1, cat1),
//                    new Seat(7, row1, cat1),
//                    new Seat(8, row1, cat2),
//                    new Seat(9, row1, cat2),
//                    new Seat(10, row1, cat2),
//                    new Seat(1, row2, cat2),
//                    new Seat(2, row2, cat2),
//                    new Seat(3, row2, cat2),
//                    new Seat(4, row2, cat1),
//                    new Seat(5, row2, cat1),
//                    new Seat(6, row2, cat1),
//                    new Seat(7, row2, cat1),
//                    new Seat(8, row2, cat2),
//                    new Seat(9, row2, cat2),
//                    new Seat(10, row2, cat2),
//                    new Seat(1, row3, cat2),
//                    new Seat(2, row3, cat2),
//                    new Seat(3, row3, cat2),
//                    new Seat(4, row3, cat1),
//                    new Seat(5, row3, cat1),
//                    new Seat(6, row3, cat1),
//                    new Seat(7, row3, cat1),
//                    new Seat(8, row3, cat2),
//                    new Seat(9, row3, cat2),
//                    new Seat(10, row3, cat2),
//                    new Seat(1, row12, cat2),
//                    new Seat(2, row12, cat2),
//                    new Seat(3, row12, cat2),
//                    new Seat(4, row12, cat1),
//                    new Seat(5, row12, cat1),
//                    new Seat(6, row12, cat1),
//                    new Seat(7, row12, cat1),
//                    new Seat(8, row12, cat2),
//                    new Seat(9, row12, cat2),
//                    new Seat(10, row12, cat2)
//
//            ));
//
//            seatRepository.saveAll(seatList);
//
//
//            Attachment movieImg = attachmentRepository.save(new Attachment("movieImg", "image/jpg", 100000));
//
//
//            List<Cast> castList = new ArrayList<>(Arrays.asList(
//                    new Cast("Aziz", null, CastType.CAST_ACTOR),
//                    new Cast("Abror", null, CastType.CAST_ACTOR),
//                    new Cast("Avaz", null, CastType.CAST_ACTOR),
//                    new Cast("Eldor", null, CastType.CAST_ACTOR)
//            ));
//            List<Cast> savedCastList = castRepository.saveAll(castList);
//
//            Movie movie1 = movieRepository.save(new Movie(
//                    "Movie 1",
//                    "dsgsdgsdg",
//                    90,
//                    50000.0,
//                    "youtube.com/hahah",
//                    movieImg,
//                    new Date(),
//                    5_000_000.0,
//                    null,
//                    50.0,
//                    savedCastList,
//                    null
//            ));
//
//        }
//        Row row111 = new Row(11111, null);
//
//        List<Seat> seatList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            seatList.add(
//                    new Seat(i+1, row111,null)
//            );

//            seatRepository.save(new Seat(i + 1, savedRow, null));
        }

//        row111.setSeats(seatList);
//
//        Row savedRow = rowRepository.save(row111);



    }
//}
