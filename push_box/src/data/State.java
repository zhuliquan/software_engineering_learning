package data;

public class State {
	public Coordinate getWorkerPosition() {
		return workerPosition;
	}
	public void setWorkerPosition(Coordinate workerPosition) {
		this.workerPosition = workerPosition;
	}
	public Coordinate getBoxPosition() {
		return boxPosition;
	}
	public void setBoxPosition(Coordinate boxPosition) {
		this.boxPosition = boxPosition;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	private Coordinate workerPosition;
	private Coordinate boxPosition;
	private int step;
	public State() {}
	public State(Coordinate workerPosition, Coordinate boxPosition, int step) {
		super();
		this.workerPosition = workerPosition;
		this.boxPosition = boxPosition;
		this.step = step;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boxPosition == null) ? 0 : boxPosition.hashCode());
		result = prime * result + step;
		result = prime * result + ((workerPosition == null) ? 0 : workerPosition.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (boxPosition == null) {
			if (other.boxPosition != null)
				return false;
		} else if (!boxPosition.equals(other.boxPosition))
			return false;
		if (step != other.step)
			return false;
		if (workerPosition == null) {
			if (other.workerPosition != null)
				return false;
		} else if (!workerPosition.equals(other.workerPosition))
			return false;
		return true;
	}
	
}
