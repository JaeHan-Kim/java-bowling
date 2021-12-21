package bowling.domain.state;

import bowling.domain.Pins;
import bowling.domain.Pitch;
import bowling.domain.Score;
import bowling.domain.frame.Frame;
import bowling.domain.state.end.Strike;

public class Start implements State {

    @Override
    public State run(Pitch pitch, Frame frame) {
        Pins pins = pitch.run();
        frame.addPitch(pitch);
        if (pins.isStrike()) {
            return checkFrame(frame, pins);
        }
        return new Progress(pins);
    }

    private State checkFrame(Frame frame, Pins pins) {
        if (frame.isFinal()) {
            return new Progress(pins, true);
        }
        return Strike.from();
    }

    @Override
    public boolean progressing() {
        return true;
    }

    @Override
    public Score score() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Score calculateBonusScore(Score beforeScore) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String symbol() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "Start{}";
    }
}
