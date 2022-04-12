package com.nuriddin.myCinemaRoom.common;

import com.nuriddin.myCinemaRoom.entity.*;
import com.nuriddin.myCinemaRoom.enums.AgeRate;
import com.nuriddin.myCinemaRoom.enums.Genre;
import com.nuriddin.myCinemaRoom.enums.MovieContractStatus;
import com.nuriddin.myCinemaRoom.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Transactional
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    @Value("alway")
    String initMode;


    private final LocationRepository locationRepository;

    private final CityRepository cityRepository;

    private final TheatreRepository theatreRepository;

    private final AttachmentRepo attachmentRepo;

    private final RowRepository rowRepository;

    private final SeatRepository seatRepository;

    private final AddressInfoRepository addressInfoRepository;

    private final MovieRepository movieRepository;

    private final DistributorRepository distributorRepository;

    private final MovieContractRepository movieContractRepository;

    private final UserRepository userRepository;

    private final TicketRepository ticketRepository;

    private final MovieSessionRepository movieSessionRepository;

    private final SessionDateRepository sessionDateRepository;

    private final SessionTimeRepository sessionTimeRepository;

    private final AnnouncementRepository announcementRepository;

    @Override
    public void run(String... args) throws Exception {

        if (initMode.equals("always")) {

            List<City> cityList = new ArrayList<>(Arrays.asList(
                    new City("New York City"),
                    new City("San Francisco"),
                    new City("Houston")
            ));
            cityRepository.saveAll(cityList);


            List<Location> locationList = new ArrayList<>(Arrays.asList(
                    new Location("9.2004305", "48.5373555"),
                    new Location("102.026135", "-0.7739574"),
                    new Location("-86.9035511", "12.5077895")
            ));
            locationRepository.saveAll(locationList);

            Location byLongtitude1 = locationRepository.findByLongtitude("9.2004305");
            Location byLongtitude2 = locationRepository.findByLongtitude("102.026135");
            Location byLongtitude3 = locationRepository.findByLongtitude("-86.9035511");


            List<AddressInfo> addressInfoList = new ArrayList<>(Arrays.asList(
                    new AddressInfo("Brooklyn", "445 Albee Square West", byLongtitude1),
                    new AddressInfo("Lower Manhattan", "28 Liberty Street, Suite SC301", byLongtitude2)

            ));
            addressInfoRepository.saveAll(addressInfoList);


            AddressInfo brooklyn = addressInfoRepository.findByTown("Brooklyn");
            AddressInfo lower_manhattan = addressInfoRepository.findByTown("Lower Manhattan");

            City new_york_city = cityRepository.findByName("New York City");
            City san_francisco = cityRepository.findByName("San Francisco");
            City houston = cityRepository.findByName("Houston");

            List<Theatre> theatreList = new ArrayList<>(Arrays.asList(
                    new Theatre("Theatre 1", "718-513-2547", new_york_city, brooklyn),
                    new Theatre("Theatre 2", "332-216-3200", new_york_city, lower_manhattan)
                    //TODO: 28.03.2022 add more theatres

            ));
            theatreRepository.saveAll(theatreList);


            Theatre theatre1 = theatreRepository.findByName("Theatre 1");
            Theatre theatre2 = theatreRepository.findByName("Theatre 2");

            addSeatsToTheatre(theatre1);


            addSeatsToTheatre(theatre2);


            Movie the_batman = new Movie(
                    "THE BATMAN",
                    "ROBERT PATTINSON CLEANS UP THE MEAN STREETS OF GOTHAM",
                    "What do you get when you mix an unstable orphan, an unlimited gadget budget, and the most crime-ridden city in the world? Justice, and lots of it. The Caped Crusader is back on the big screen in Matt Reeves’ (WAR FOR THE PLANET OF THE APES) THE BATMAN. Robert Pattinson (THE LIGHTHOUSE) dons the cowl to tackle corruption and a puzzling new adversary, the Riddler, played by Paul Dano (PRISONERS).",
                    AgeRate.PG,
                    (short) 176,
                    (short) 2022,
                    Genre.FOREIGN,
                    attachmentRepo.findById(1L).orElse(null),
                    "https://www.youtube.com/watch?v=u34gHaRiBIU"
            );
            movieRepository.save(the_batman);

            Movie apollo = new Movie(
                    "APOLLO 10 1/2: A SPACE AGE CHILDHOOD",
                    "THE COMING-OF-AGE STORY INSPIRED BY DIRECTOR RICHARD LINKLATER'S OWN LIFE",
                    "APOLLO 10 1/2 tells the story of the first moon landing in the summer of 1969 from two interwoven perspectives. It both captures the astronaut and mission control view of the triumphant moment, and the lesser-seen bottom-up perspective of what it was like from an excited kid’s perspective, living near NASA but mostly watching it on TV like hundreds of millions of others.",
                    AgeRate.NR,
                    (short) 97,
                    (short) 2022,
                    Genre.CARTOON,
                    attachmentRepo.findById(2L).orElse(null),
                    "https://www.youtube.com/watch?v=Dzuz5s_Qk-A"
            );
            movieRepository.save(apollo);

            Movie sonic = new Movie(
                    "SONIC THE HEDGEHOG 2",
                    "SONIC & TAILS KNUCKLE DOWN TO SAVE THE WORLD",
                    """
                            Sonic (aka The Spiky Supernova, aka Blue Justice) is back for a turbo-charged team-up to save the world from a chaotic roboticist and one messed-up monotreme. We join our spiky hero living his best life in Green Hills – good friends, good deeds, and good food (mostly chili dogs). His world is turned upside down when his nemesis, Dr. Robotnik, returns with a prickly echidna, Knuckles by his side in search of a civilization-shattering emerald. Even with a new sidekick, Tails, by his side, Sonic’s going to need an extra life or two to beat this level.

                            SONIC THE HEDGEHOG 2 is perfect for families, and promises to be a high octane nostalgia trip for anyone who grew up fighting with their sibling over who got to play first. Returning stars James Marsden, Ben Schwartz, Jim Carrey, and Tika Sumpter are joined by new players Idris Elba and Colleen O'Shaughnessey.""",
                    AgeRate.PG,
                    (short) 122,
                    (short) 2022,
                    Genre.CARTOON,
                    attachmentRepo.findById(3L).orElse(null),
                    "https://www.youtube.com/watch?v=G5kzUpWAusI"
            );
            movieRepository.save(sonic);

            Distributor distributor = new Distributor("Warner Bros. Pictures", "Warner Bros. Entertainment Inc. is an American diversified multinational mass media and entertainment conglomerate headquartered at the Warner Bros. Studios complex in Burbank, California, and a subsidiary of AT&T's WarnerMedia through its Studios & Networks division",
                    0.0);
            distributorRepository.save(distributor);


            MovieContract movieContract1 = new MovieContract(
                    movieRepository.findByName("APOLLO 10 1/2: A SPACE AGE CHILDHOOD"),
                    (short) 51,
                    (short) 50,
                    19.0,
                    MovieContractStatus.SOON

            );
            movieContractRepository.save(movieContract1);
            MovieContract  movieContract2 = new MovieContract(
                    movieRepository.findByName("THE BATMAN"),
                    (short) 51,
                    (short) 50,
                    17.0,
                    MovieContractStatus.ACTIVE

            );
            movieContractRepository.save(movieContract2);

            MovieContract  movieContract3 = new MovieContract(
                    movieRepository.findByName("SONIC THE HEDGEHOG 2"),
                    (short) 51,
                    (short) 50,
                    21.0,
                    MovieContractStatus.ACTIVE

            );
            movieContractRepository.save(movieContract3);

            userRepository.save(new User(
                    "Nuriddin",
                    "Qurbonboyev",
                    "nur",
                    "+998901144223",
                    "nu2001",
                    new_york_city
            ));


            ArrayList<Announcement> announcements = new ArrayList<>(Arrays.asList(
                    new Announcement(movieContractRepository.findById(1L).get(), true),
                    new Announcement(movieContractRepository.findById(2L).get(), true),
                    new Announcement(movieContractRepository.findById(3L).get(), true)

            ));

            announcementRepository.saveAll(announcements);

            ArrayList<SessionDate> sessionDates = new ArrayList<>(Arrays.asList(
                    new SessionDate(LocalDate.parse("2022-05-01")),
                    new SessionDate(LocalDate.parse("2022-05-02")),
                    new SessionDate(LocalDate.parse("2022-05-03"))
            ));

            sessionDateRepository.saveAll(sessionDates);

            ArrayList<SessionTime> sessionTimes = new ArrayList<>(Arrays.asList(
                    new SessionTime(LocalTime.of(10,0)),
                    new SessionTime(LocalTime.of(12,0)),
                    new SessionTime(LocalTime.of(14,0))
            ));

            sessionTimeRepository.saveAll(sessionTimes);



            ArrayList<MovieSession> movieSessions = new ArrayList<>(Arrays.asList(
                    new MovieSession(
                                                theatreRepository.findByName("Theatre 1"),
                            sessionDateRepository.findByDate(LocalDate.parse("2022-05-01")),
                            sessionTimeRepository.findByTime(LocalTime.of(10,0)),
                            sessionTimeRepository.findByTime(LocalTime.of(12,0)),
                            announcementRepository.findById(1L).get()
                                        ),
                    new MovieSession(
                                                theatreRepository.findByName("Theatre 1"),
                            sessionDateRepository.findByDate(LocalDate.parse("2022-05-01")),
                            sessionTimeRepository.findByTime(LocalTime.of(12,0)),
                            sessionTimeRepository.findByTime(LocalTime.of(14,0)),
                            announcementRepository.findById(2L).get()
                                        ),
                    new MovieSession(
                                                theatreRepository.findByName("Theatre 2"),
                            sessionDateRepository.findByDate(LocalDate.parse("2022-05-01")),
                            sessionTimeRepository.findByTime(LocalTime.of(10,0)),
                            sessionTimeRepository.findByTime(LocalTime.of(12,0)),
                            announcementRepository.findById(3L).get()
                                        )
            ));

            movieSessionRepository.saveAll(movieSessions);




        }
    }

    private void addSeatsToTheatre(Theatre Theatre) {
        Row row10 = rowRepository.save(new Row(1, Theatre));
        Row row20 = rowRepository.save(new Row(2, Theatre));
        Row row30 = rowRepository.save(new Row(3, Theatre));

        List<Seat> seatList10 = new ArrayList<>(Arrays.asList(
                new Seat(1, row10),
                new Seat(2, row10),
                new Seat(3, row10),
                new Seat(4, row10),
                new Seat(5, row10),
                new Seat(6, row10),
                new Seat(7, row10),
                new Seat(8, row10),
                new Seat(9, row10),
                new Seat(10, row10),
                new Seat(1, row20),
                new Seat(2, row20),
                new Seat(3, row20),
                new Seat(4, row20),
                new Seat(5, row20),
                new Seat(6, row20),
                new Seat(7, row20),
                new Seat(8, row20),
                new Seat(9, row20),
                new Seat(10, row20),
                new Seat(1, row30),
                new Seat(2, row30),
                new Seat(3, row30),
                new Seat(4, row30),
                new Seat(5, row30),
                new Seat(6, row30),
                new Seat(7, row30),
                new Seat(8, row30),
                new Seat(9, row30),
                new Seat(10, row30)
        ));

        seatRepository.saveAll(seatList10);
    }

}