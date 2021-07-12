package vision.integrity.wordwebgame.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameCheckerService {
    List<String> checkList(List<String> inputList);
}
