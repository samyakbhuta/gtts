Gujarati Text-to-Speech
-----------------------
Takes arbitrary Gujarati unicode characters and produces equivalent speech. WIP.

### Requirement

Java version 1.7.0

### How to start

```
java -cp bin project.gui.APPGTTS
```

### How to contribute

#### As developer

Please start forking this project and send your pull requests.

##### Synthesis how ?

Curious how TTS works ? Here is a small [presentation] (http://www.slideshare.net/samyakbhuta/gujarati-texttospeech-presentation). We have selected an approach where earlier segmented speech units are concatenated on runtime to produce speech.

#### As non-developer

##### Help us segement

We need volunteers for segmenting the recorded spoken words to complete our database of Segement Speech Units. See details here at [Segmentation] (https://github.com/samyakbhuta/gtts/wiki/Segmentation).

##### Help us with your knowledge of Gujarati Language

Volunteers are needed to build extensive list of accryonyms and abbreviations that Gujarati language has seen and/or continues to see in written form. Add your entries [here] (https://github.com/samyakbhuta/gtts/blob/master/project/ss/lang/gu/prepro/GujLookUp.txt)
