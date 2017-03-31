import speech_recognition as sr
import sys

orig_stdout = sys.stdout
f = file('out.txt', 'w')
sys.stdout = f

r = sr.Recognizer()
m = sr.Microphone()

try:
    with m as source: r.adjust_for_ambient_noise(source)
    check = 0
    while (check!=1):
        with m as source: audio = r.listen(source)
        try:
            # recognize speech using Google Speech Recognition
            value = r.recognize_google(audio)

            # we need some special handling here to correctly print unicode characters to standard output
            if str is bytes:  # this version of Python uses bytes for strings (Python 2)
                print("{}".format(value).encode("utf-8"))
		check=1
            else:  # this version of Python uses unicode for strings (Python 3+)
                print("{}".format(value))
		check=1
        except sr.UnknownValueError:
            print("Oops! Didn't catch that")
	    check=1
        except sr.RequestError as e:
            print("Uh oh! Couldn't request results from Google Speech Recognition service; {0}".format(e))
	    check=1
except KeyboardInterrupt:
    pass
sys.stdout = orig_stdout
f.close()
