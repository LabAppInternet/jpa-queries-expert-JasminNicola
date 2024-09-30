package cat.tecnocampus.fgcstations.persistence;

import cat.tecnocampus.fgcstations.application.DTOs.StationDTO;
import cat.tecnocampus.fgcstations.application.DTOs.StationTopFavoriteJourney;
import cat.tecnocampus.fgcstations.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, String> {
    // @Query("SELECT s.name as name, s.longitud  as longitud, s.latitud as latitud  from Station s")
    @Query("""
            SELECT s From Station s
            """)
    List<StationDTO> findAllStationDTO();


    Optional<Station> findByName(String name);

    @Query("""
            SELECT s From Station s WHERE s.name=:name
            """)
    Optional<StationDTO> findbyNameDTO(String name);
}
