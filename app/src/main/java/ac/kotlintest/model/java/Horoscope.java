package ac.kotlintest.model.java;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "horo", strict = false)
public class Horoscope {

    @Element(name = "aries") public Aries aries;
    @Element(name = "taurus") public Taurus taurus;
    @Element(name = "gemini") public Gemini gemini;
    @Element(name = "cancer") public Cancer cancer;
    @Element(name = "leo") public Leo leo;
    @Element(name = "virgo") public Virgo virgo;
    @Element(name = "libra") public Libra libra;
    @Element(name = "scorpio") public Scorpio scorpio;
    @Element(name = "sagittarius") public Sagittarius sagittarius;
    @Element(name = "capricorn") public Capricorn capricorn;
    @Element(name = "aquarius") public Aquarius aquarius;
    @Element(name = "pisces") public Pisces pisces;

    public String getAriesToday(){
        return aries.today;
    }
    public String getAriesYesterday() {return aries.yesterday;}
    public String getArieTomorrow() {return aries.tomorrow;}
    public String getAriesTomorrow02() {return aries.tomorrow02;}

    public String getTaurusToday(){
        return taurus.today;
    }
    public String getTaurusYesterday() {return taurus.yesterday;}
    public String getTaurusTomorrow() {return taurus.tomorrow;}
    public String getTaurusTomorrow02() {return taurus.tomorrow02;}

    public String getGeminiToday(){
        return gemini.today;
    }
    public String getGeminiYesterday() {return gemini.yesterday;}
    public String getGeminiTomorrow() {return gemini.tomorrow;}
    public String getGeminiTomorrow02() {return gemini.tomorrow02;}

    public String getCancerToday(){
        return cancer.today;
    }
    public String getCancerYesterday() {return cancer.yesterday;}
    public String getCancerTomorrow() {return cancer.tomorrow;}
    public String getCancerTomorrow02() {return cancer.tomorrow02;}

    public String getLeoToday(){
        return leo.today;
    }
    public String getLeoYesterday() {return leo.yesterday;}
    public String getLeoTomorrow() {return leo.tomorrow;}
    public String getLeoTomorrow02() {return leo.tomorrow02;}

    public String getVirgoToday(){
        return virgo.today;
    }
    public String getVirgoYesterday() {return virgo.yesterday;}
    public String getVirgoTomorrow() {return virgo.tomorrow;}
    public String getVirgoTomorrow02() {return virgo.tomorrow02;}

    public String getLibraToday(){
        return libra.today;
    }
    public String getLibraYesterday() {return libra.yesterday;}
    public String getLibraTomorrow() {return libra.tomorrow;}
    public String getLibraTomorrow02() {return libra.tomorrow02;}

    public String getScorpioToday(){
        return scorpio.today;
    }
    public String getScorpioYesterday() {return scorpio.yesterday;}
    public String getScorpioTomorrow() {return scorpio.tomorrow;}
    public String getScorpioTomorrow02() {return scorpio.tomorrow02;}

    public String getSagittariusToday(){
        return sagittarius.today;
    }
    public String getSagittariusYesterday() {return sagittarius.yesterday;}
    public String getSagittariusTomorrow() {return sagittarius.tomorrow;}
    public String getSagittariusTomorrow02() {return sagittarius.tomorrow02;}

    public String getCapricornToday(){
        return capricorn.today;
    }
    public String getCapricornYesterday() {return capricorn.yesterday;}
    public String getCapricornTomorrow() {return capricorn.tomorrow;}
    public String getCapricornTomorrow02() {return capricorn.tomorrow02;}

    public String getAquariusToday(){
        return aquarius.today;
    }
    public String getAquariusYesterday() {return aquarius.yesterday;}
    public String getAquariusTomorrow() {return aquarius.tomorrow;}
    public String getAquariusTomorrow02() {return aquarius.tomorrow02;}

    public String getPiscesToday(){
        return pisces.today;
    }
    public String getPiscesYesterday() {return pisces.yesterday;}
    public String getPiscesTomorrow() {return pisces.tomorrow;}
    public String getPiscesTomorrow02() {return pisces.tomorrow02;}
}

@Root(strict = false)
class Aries {
    @Element(name = "today") public String today;
    @Element(name = "yesterday") public String yesterday;
    @Element(name = "tomorrow") public String tomorrow;
    @Element(name = "tomorrow02") public String tomorrow02;
}

@Root(strict = false)
class Taurus{
    @Element(name = "today") public String today;
    @Element(name = "yesterday") public String yesterday;
    @Element(name = "tomorrow") public String tomorrow;
    @Element(name = "tomorrow02") public String tomorrow02;
}

@Root(strict = false)
class Gemini{
    @Element(name = "today") public String today;
    @Element(name = "yesterday") public String yesterday;
    @Element(name = "tomorrow") public String tomorrow;
    @Element(name = "tomorrow02") public String tomorrow02;
}

@Root(strict = false)
class Cancer{
    @Element(name = "today") public String today;
    @Element(name = "yesterday") public String yesterday;
    @Element(name = "tomorrow") public String tomorrow;
    @Element(name = "tomorrow02") public String tomorrow02;
}

@Root(strict = false)
class Leo{
    @Element(name = "today") public String today;
    @Element(name = "yesterday") public String yesterday;
    @Element(name = "tomorrow") public String tomorrow;
    @Element(name = "tomorrow02") public String tomorrow02;
}

@Root(strict = false)
class Virgo{
    @Element(name = "today") public String today;
    @Element(name = "yesterday") public String yesterday;
    @Element(name = "tomorrow") public String tomorrow;
    @Element(name = "tomorrow02") public String tomorrow02;
}

@Root(strict = false)
class Libra{
    @Element(name = "today") public String today;
    @Element(name = "yesterday") public String yesterday;
    @Element(name = "tomorrow") public String tomorrow;
    @Element(name = "tomorrow02") public String tomorrow02;
}


@Root(strict = false)
class Scorpio{
    @Element(name = "today") public String today;
    @Element(name = "yesterday") public String yesterday;
    @Element(name = "tomorrow") public String tomorrow;
    @Element(name = "tomorrow02") public String tomorrow02;
}

@Root(strict = false)
class Sagittarius{
    @Element(name = "today") public String today;
    @Element(name = "yesterday") public String yesterday;
    @Element(name = "tomorrow") public String tomorrow;
    @Element(name = "tomorrow02") public String tomorrow02;
}

@Root(strict = false)
class Capricorn{
    @Element(name = "today") public String today;
    @Element(name = "yesterday") public String yesterday;
    @Element(name = "tomorrow") public String tomorrow;
    @Element(name = "tomorrow02") public String tomorrow02;
}

@Root(strict = false)
class Aquarius{
    @Element(name = "today") public String today;
    @Element(name = "yesterday") public String yesterday;
    @Element(name = "tomorrow") public String tomorrow;
    @Element(name = "tomorrow02") public String tomorrow02;
}

@Root(strict = false)
class Pisces{
    @Element(name = "today") public String today;
    @Element(name = "yesterday") public String yesterday;
    @Element(name = "tomorrow") public String tomorrow;
    @Element(name = "tomorrow02") public String tomorrow02;
}




