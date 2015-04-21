package ie.gmit.dip.sound;

import java.applet.AudioClip;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
/** <p>Created the sound for DASH and DOT</p>
 * <p>Created with the <a href="http://stephengware.com/projects/soundtoclass">SoundToClass tool</a>, by Stephen G. Ware.</p>
 * */
public class MorseCodeSound implements AudioClip {
	private byte[] dataDash;
	private byte[] dataDot;
	private AudioFormat format;
	private DataLine.Info lineInfo = null;
	private PlayThread playThread = null;
	private LoopThread loopThread = null;
	
	private static byte[] data0(){ return new byte[] {-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8}; }
	private static byte[] data1(){ return new byte[] {-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7,7,53,-128,-54,-8,-8,-54,127,53,7}; }
	
	/**
	 * @return <code>byte[]</code> -> Data to play the sound of DASH
	 */
	private static byte[] getDataForDashSound(){
		byte[] data = new byte[1024];
		System.arraycopy(data0(), 0, data, 0, 1024);
		
		return data;
	}
	
	/**@return <code>byte[]</code> - Data to play the sound of DOT*/
	private static byte[] getDataForDotSound(){
		
			byte[] data = new byte[512];
			System.arraycopy(data1(), 0, data, 0, 512);
			
			return data;
		
	}

	/** Constructs a new AudioClip with the data from Mo.wav. */
	public MorseCodeSound(){
		dataDash = getDataForDashSound();
		dataDot = getDataForDotSound();
		format = new AudioFormat(AudioFormat.Encoding.PCM_UNSIGNED, (float)(8000.0), 8, 1, 1, (float)(8000.0), false);
		lineInfo = new DataLine.Info(SourceDataLine.class, format, AudioSystem.NOT_SPECIFIED);
		try{ AudioSystem.getLine(lineInfo); }
		catch(IllegalArgumentException ex){ lineInfo = null; }
		catch(LineUnavailableException e){}
	}
	/** A separate thread for playing Mo.wav. */
	private class PlayThread extends Thread {
		private byte[] data;
		private AudioFormat format;
		private DataLine.Info lineInfo;
		private SourceDataLine line = null;
		private boolean playing = true;
		public PlayThread(byte[] d, AudioFormat f, DataLine.Info i){ data = d; format = f; lineInfo = i; }
		public void run(){
			try{
				line = (SourceDataLine) AudioSystem.getLine(lineInfo);
				line.open(format, AudioSystem.NOT_SPECIFIED);
				line.start();
				int written = 0;
				int available;
				while(written < data.length && playing){
					available = Math.min(line.available(), data.length - written);
					line.write(data, written, available);
					written += available;
				}
				int frames = data.length / format.getFrameSize();
				while(line.getFramePosition() < frames && playing) Thread.sleep(0);
			}
			catch(InterruptedException ex){ playing = false; }
			catch(LineUnavailableException ex){}
			if(line != null){ line.stop(); line.flush(); line.close(); }
			playing = false;
		}
		public void interrupt(){ playing = false; }
		public boolean isPlaying(){ return playing; }
	}
	/** A separate thread for looping play of Mo.wav. */
	private class LoopThread extends Thread {
		private MorseCodeSound clip;
		private boolean looping = true;
		public LoopThread(MorseCodeSound c){ clip = c; }
		public void run(){
			while(looping){
				clip.play();
				while(clip.isPlaying() && looping){
					try{ Thread.sleep(0); }
					catch(InterruptedException ex){ looping = false; break; }
				}
			}
			if(!clip.isLooping()) clip.stop();
		}
		public void interrupt(){ looping = false; }
		public boolean isLooping(){ return looping; }
	}
	
	/** Plays the DASH sound from the beginning, even if it is already playing or looping. */
	public void playDash(){ if(lineInfo == null) return; doPlayDash(); }
	private synchronized void doPlayDash(){
		doStopPlay();
		playThread = new PlayThread(dataDash, format, lineInfo);
		playThread.start();
	}
	
	/** Plays the DOT sound from the beginning, even if it is already playing or looping. */
	public void playDot(){ if(lineInfo == null) return; doPlayDot(); }
	private synchronized void doPlayDot(){
		doStopPlay();
		playThread = new PlayThread(dataDot, format, lineInfo);
		playThread.start();
	}
	
	/** Plays Mo.wav continuously until stopped. */
	public void loop(){ if(lineInfo == null) return; doLoop(); }
	private synchronized void doLoop(){
		doStopLoop();
		loopThread = new LoopThread(this);
		loopThread.start();
	}
	/** Stops play and looping of Mo.wav. */
	public void stop(){ if(lineInfo == null) return; doStop(); }
	private synchronized void doStop(){
		doStopPlay();
		doStopLoop();
	}
	private void doStopPlay(){
		if(playThread == null) return;
		if(playThread.isPlaying()) playThread.interrupt();
		playThread = null;
	}
	private void doStopLoop(){
		if(loopThread == null) return;
		if(loopThread.isLooping()) loopThread.interrupt();
		loopThread = null;
	}
	/** Tests if Mo.wav is currently playing or looping.
	 * @return <tt>true</tt> if playing or looping, <tt>false</tt> otherwise */
	public boolean isPlaying(){ if(lineInfo == null) return false; return doIsPlaying(); }
	private synchronized boolean doIsPlaying(){
		if(loopThread == null && playThread == null) return false;
		else if(loopThread == null) return playThread.isPlaying();
		else if(playThread == null) return loopThread.isLooping();
		else return loopThread.isLooping() && playThread.isPlaying();
	}
	/** Tests if Mo.wav is currently looping.
	 * @return <tt>true</tt> if looping, <tt>false</tt> otherwise */
	public boolean isLooping(){ if(lineInfo == null) return false; return doIsLooping(); }
	private synchronized boolean doIsLooping(){
		if(loopThread == null) return false;
		else return loopThread.isLooping();
	}
	@Override
	public void play() {
		System.out.println("@Override play... ");
	}
}