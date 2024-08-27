package dev.ruchir.notes_lake.service.impl;

import dev.ruchir.notes_lake.dto.FeedbackDTO;
import dev.ruchir.notes_lake.mapper.FeedbackMapper;
import dev.ruchir.notes_lake.model.Core.Feedback;
import dev.ruchir.notes_lake.repository.FeedbackRepository;
import dev.ruchir.notes_lake.controller_advise.custom.FeedbackNotFoundException;
import dev.ruchir.notes_lake.service.interfaces.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, FeedbackMapper feedbackMapper) {
        this.feedbackRepository = feedbackRepository;
        this.feedbackMapper = feedbackMapper;
    }

    @Override
    public FeedbackDTO createFeedback(FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackMapper.toEntity(feedbackDTO);
        Feedback savedFeedback = feedbackRepository.save(feedback);
        return feedbackMapper.toDto(savedFeedback);
    }

    @Override
    public FeedbackDTO updateFeedback(Long id, FeedbackDTO feedbackDTO) {
        if (!feedbackRepository.existsById(id)) {
            throw new FeedbackNotFoundException("Feedback with ID " + id + " not found.");
        }
        Feedback feedback = feedbackMapper.toEntity(feedbackDTO);
        feedback.setId(id); // Ensure the ID is set for update
        Feedback updatedFeedback = feedbackRepository.save(feedback);
        return feedbackMapper.toDto(updatedFeedback);
    }

    @Override
    public void deleteFeedback(Long id) {
        if (!feedbackRepository.existsById(id)) {
            throw new FeedbackNotFoundException("Feedback with ID " + id + " not found.");
        }
        feedbackRepository.deleteById(id);
    }

    @Override
    public FeedbackDTO getFeedbackById(Long id) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new FeedbackNotFoundException("Feedback with ID " + id + " not found."));
        return feedbackMapper.toDto(feedback);
    }

    @Override
    public List<FeedbackDTO> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        return feedbacks.stream()
                .map(feedbackMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FeedbackDTO> getFeedbacksByUserId(Long userId) {
        List<Feedback> feedbacks = feedbackRepository.findByUserId(userId);
        return feedbacks.stream()
                .map(feedbackMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FeedbackDTO> getFeedbacksByHandwrittenNoteId(Long handwrittenNoteId) {
        List<Feedback> feedbacks = feedbackRepository.findByHandwrittenNoteId(handwrittenNoteId);
        return feedbacks.stream()
                .map(feedbackMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FeedbackDTO> getFeedbacksByTypedNoteId(Long typedNoteId) {
        List<Feedback> feedbacks = feedbackRepository.findByTypedNoteId(typedNoteId);
        return feedbacks.stream()
                .map(feedbackMapper::toDto)
                .collect(Collectors.toList());
    }
}
