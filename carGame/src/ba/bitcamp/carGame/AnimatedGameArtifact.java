package ba.bitcamp.carGame;

public interface AnimatedGameArtifact extends GameArtifact {
	void animateFrame(long frameNumber);

	void setSpeed(int speed);
}
