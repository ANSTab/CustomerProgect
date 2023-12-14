package ApiObject;

public class Subject {
    public enum Arts {
        ARCHITECTURE("Architecture"),
        ART_INSTRUCTION("Art Instruction"),
        ART_HISTORY("Art History"),
        DANCE("Dance"),
        DESIGN("Design"),
        FASHION("Fashion"),
        FILM("Film"),
        GRAPHIC_DESIGN("Graphic Design"),
        MUSIC("Music"),
        MUSIC_THEORY("Music Theory"),
        PAINTING("Painting"),
        PHOTOGRAPHY("Photography");

        final String name;

        public String getName() {
            return name;
        }

        Arts(String name) {
            this.name = name;
        }
    }

    public enum Animals {
        BEARS("Bears"),
        CATS("Cats"),
        KITTENS("Kittens"),
        DOGS("Dogs"),
        PUPPIES("Puppies");

        final String name;

        public String getName() {
            return name;
        }

        Animals(String name) {
            this.name = name;
        }
    }

    public enum ScienceAndMathematics {
        BIOLOGY("Biology"),
        CHEMISTRY("Chemistry"),
        MATHEMATICS("Mathematics"),
        PHYSICS("Physics"),
        PROGRAMMING("Programming");

        final String name;

        public String getName() {
            return name;
        }

        ScienceAndMathematics(String name) {
            this.name = name;
        }
    }

    public enum Biography {
        AUTOBIOGRAPHIES("Autobiographies"),
        HISTORY("History"),
        POLITICS_AND_GOVERNMENT("Politics and Government"),
        WORLD_WAR_II(" World War II"),
        WOMEN("Women"),
        KINGS_AND_RULERS("Kings and Rulers"),
        COMPOSERS("Composers"),
        ARTISTS("Artists");

        final String name;

        public String getName() {
            return name;
        }

        Biography(String name) {
            this.name = name;
        }
    }

}
