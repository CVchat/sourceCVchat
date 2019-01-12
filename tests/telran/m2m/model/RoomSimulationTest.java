package telran.m2m.model;

import org.junit.jupiter.api.Test;


class RoomSimulationTest {
    /**
     * Test function to generate a random sentence
     *
     */
    @Test
    void startRoomSimulation() {
        for (int i = 0; i < 100; i++) {
            SourceSentences sourceSentences = new SourceSentences();
            System.out.println(i);
            System.out.println(sourceSentences.sentence());
        }
    }
}