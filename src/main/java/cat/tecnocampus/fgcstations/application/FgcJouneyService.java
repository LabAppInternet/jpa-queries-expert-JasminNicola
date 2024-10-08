package cat.tecnocampus.fgcstations.application;

import cat.tecnocampus.fgcstations.application.DTOs.JourneyDTO;
import cat.tecnocampus.fgcstations.application.exception.JourneyDoesNotExistsException;
import cat.tecnocampus.fgcstations.domain.Journey;
import cat.tecnocampus.fgcstations.domain.JourneyId;
import cat.tecnocampus.fgcstations.persistence.JourneyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FgcJouneyService {
    private final JourneyRepository journeyRepository;

    public FgcJouneyService(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    public List<Journey> getAllJourneysDomain() {
        //TODO 6: get all stations (see you return a domain Journey). Actually, you don't need to leave this file
        // in order to complete this exercise
        return journeyRepository.findAll();
    }

    public List<JourneyDTO> getAllJourneysDTO() {
        //TODO 7: get all journeys (see the returned type)
        List<JourneyDTO> journeyDTOList = journeyRepository.findAllDTO();
        return journeyRepository.findAllDTO();
    }

    public Journey getJourneyDomain(String origin, String destination) {
        // TODO 8: get a journey by origin and destination (domain). If the journey does not exist, throw a JourneyDoesNotExistsException
        //  try no to use any sql (jpql) query, just come up with an appropriate method name
        //Journey journey= journeyRepository.findByNameDestination(origin,destination).get();
        return journeyRepository.findById(new JourneyId(origin, destination)).orElseThrow(() -> new JourneyDoesNotExistsException(origin, destination));


    }

    public JourneyId getJourneyId(String origin, String destination) {
        // TODO 9: get a journey ID by origin and destination (domain JourneyId). If the journey does not exist, throw a JourneyDoesNotExistsException
        //  try no to use any sql (jpql) query, just come up with an appropriate method name

        Journey j= journeyRepository.findById(new JourneyId(origin, destination)).orElseThrow(() -> new JourneyDoesNotExistsException(origin, destination));
        JourneyId journeyId = new JourneyId(origin, destination);

        return journeyId;

    }
}
