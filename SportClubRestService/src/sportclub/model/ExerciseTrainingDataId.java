package sportclub.model;

import java.io.Serializable;

import javax.persistence.*;



@SuppressWarnings("serial")
@Embeddable
public class ExerciseTrainingDataId implements Serializable {
	//@Column(name = "trainingPoolId", nullable = false)
	int trainingPoolId;
	//@Column(name = "exerciseId", nullable = false)
	int exerciseId;
		
	public ExerciseTrainingDataId() {}
	
	public ExerciseTrainingDataId(int trainingPoolId, int exerciseId) {
		this.trainingPoolId = trainingPoolId;
		this.exerciseId = exerciseId;
	}

	
	public int getTrainingPoolId() {
		return trainingPoolId;
	}
	public void setTrainingPoolId(int trainingPoolId) {
		this.trainingPoolId = trainingPoolId;
	}
	
	
	public int getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ExerciseTrainingDataId))
			return false;
		ExerciseTrainingDataId castOther = (ExerciseTrainingDataId) other;

		return (this.getTrainingPoolId() == castOther.getTrainingPoolId())
				&& ((this.getExerciseId() == castOther.getExerciseId())
						|| (this.getExerciseId() != 0 && castOther.getExerciseId() != 0
								&& this.getExerciseId()==castOther.getExerciseId()));
		
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getTrainingPoolId();
		result = 37 * result + this.getExerciseId();
		return result;
	}
	
}
