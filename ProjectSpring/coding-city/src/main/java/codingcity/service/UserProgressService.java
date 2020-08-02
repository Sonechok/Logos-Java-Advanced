package codingcity.service;

import codingcity.dto.UserProgressDTO;
import codingcity.entity.UserProgress;

public interface UserProgressService {
    UserProgressDTO createUserProgressForTask(UserProgress userProgress, Long userId);

    UserProgressDTO updateUserProgress(UserProgress userProgress);

    UserProgress findById(Long progressId);

    UserProgress findByUserIdAndTaskId(Long userId, Long taskId);
}
