package TTS;

import javax.speech.Central;
import javax.speech.EngineException;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class SpeechUtils {
	
	static float pitch = 150.0F;
	static float volume = 1.0F;
	static float rate = 160.0F ;
	static float voiceChoice = 1;
	
	public static void changeValues(float pitch1,float volume1,float rate1,int voiceChoice1){
		pitch = pitch1;
		volume = volume1;
		rate = rate1;
		voiceChoice = voiceChoice1;
	}
	
	public static Float[] getChangedValues(){
		
		Float[] list = new Float[4];
		list[0] = pitch;
		list[1] = volume;
		list[2] = rate;
		list[3] = voiceChoice;
		return list;
		
	}
	
	public static void speak(String text) throws EngineException {

		System.setProperty("FreeTTSSynthEngineCentral", "com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
		
		Voice voice;
		VoiceManager vm = VoiceManager.getInstance();
		
		if(voiceChoice == 1){
			voice = vm.getVoice("kevin16");
		}
		else{
			voice = vm.getVoice("kevin");
		}
		voice.setPitch(pitch); 
		voice.setVolume(volume); 
		voice.setRate(rate); 
		
		voice.allocate();
		
		voice.speak(text);
	}
	
	public static void main(String[] args) throws EngineException{
		SpeechUtils.speak("hello");
	}
}