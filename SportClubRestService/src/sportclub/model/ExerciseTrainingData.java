package sportclub.model;

import javax.persistence.*;

@Entity
public class ExerciseTrainingData {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exerciseId", nullable = false, insertable = false, updatable = false)
	Exercise exercise;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trainingPoolId", nullable = false, insertable = false, updatable = false)
	TrainingPool trainingPool;
	int numberOfRepeats;
	int duration;
	
	public ExerciseTrainingData() {}
	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "trainingPoolId", column = @Column(name = "trainingPoolId", nullable = false)),
			@AttributeOverride(name = "exerciseId", column = @Column(name = "exerciseId", nullable = false, length = 15)) })
	ExerciseTrainingDataId id;
	
	public ExerciseTrainingDataId getId() {
		return this.id;
	}

	public void setId(ExerciseTrainingDataId id) {
		this.id = id;
	}
	
	public Exercise getExercise() {
		return exercise;
	}
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	
	
	public TrainingPool getTrainingPool() {
		return trainingPool;
	}

	public void setTrainingPool(TrainingPool trainingPool) {
		this.trainingPool = trainingPool;
	}

	public int getNumberOfRepeats() {
		return numberOfRepeats;
	}
	public void setNumberOfRepeats(int numberOfRepeats) {
		this.numberOfRepeats = numberOfRepeats;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
