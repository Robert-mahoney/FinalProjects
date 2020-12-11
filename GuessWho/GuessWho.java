import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;
/**
 * Test
 * 
 * @author 2020 CSA
 * @version 20201123
 */
public class GuessWho
{
    static Scanner in = new Scanner(System.in);
    public static  void main(String[] args) throws InterruptedException 
    {
        
        List<Characters> character = new ArrayList<Characters>();
        populateChar(character);
    }
       
    public static void populateChar(List<Characters> character)
    {
        character.add(new AdmiralAckbar());
        character.add(new AdmiralHoldo());
        character.add(new AdmiralPiett());
        character.add(new AhsokaTano());
        character.add(new BB8());
        character.add(new BiggsDarklighter());
        character.add(new BobaFett());
        character.add(new Bossk());
        character.add(new C3PO());
        character.add(new Chewbacca());
        character.add(new ChirrutImwe());
        character.add(new CountDooku());
        character.add(new DarthMaul());
        character.add(new DarthVader());
        character.add(new Dengar());
        character.add(new Droideka());
        character.add(new EmperorPalpatine());
        character.add(new EnfysNest());
        character.add(new EzraBridger());
        character.add(new Finn());
        character.add(new GeneralGrievous());
        character.add(new GrandMoffTarkin());
        character.add(new Greedo());
        character.add(new HanSolo());
        character.add(new IG11());
        character.add(new JabbatheHut());
        character.add(new JangoFett());
        character.add(new JarJarBinks());
        character.add(new K2SO());
        character.add(new KiAdiMundi());
        character.add(new KyloRen());
        character.add(new LandoCalrissian());
        character.add(new LukeSkywalker());
        character.add(new MaceWindu());
        character.add(new MonMothma());
        character.add(new NuteGunray());
        character.add(new ObiWanKenobi());
        character.add(new PadmeAmidala());
        character.add(new PloKoon());
        character.add(new PoeDameron());
        character.add(new PrincessLeia());
        character.add(new Qira());
        character.add(new QuiGonJinn());
        character.add(new R2D2());
        character.add(new AnakinSkywalker());
        character.add(new Rex());
        character.add(new Rey());
        character.add(new WedgeAntilles());
        character.add(new Wicket());
        character.add(new Yoda());
    }
    

    
}