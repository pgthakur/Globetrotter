package com.game.globetrotter.util;

import com.game.globetrotter.dto.DestinationDTO;
import com.game.globetrotter.entities.Destination;

import java.util.ArrayList;
import java.util.List;

public class ConvertToDestinationDTOs {
    public static List<DestinationDTO> getDestinationDTOs(List<Destination> destination) {
        List<DestinationDTO> DesDtos = new ArrayList<>();
        for(var dest: destination) {
            DestinationDTO desDTOS = new DestinationDTO();
            desDTOS.setCity(dest.getCity());
            desDTOS.setCountry(dest.getCountry());
            DesDtos.add(desDTOS);
        }
        return DesDtos;

    }
}
