# Processing-Menu

Processing is a collection of Java libraries that greatly simplify graphics programming. Processing programs, called sketches, are usually designed with one window. In this repository you will find (in the midst of a great deal of junk from Eclipse) a package containing classes that that allow the easy creation of a menu window for your Processing sketch.
<br/>
<br/>
You specify which parameters are involved in the drawing that is output on your main output window, which I call a DrawingWindow, and these parameters are added to a MenuWindow. The MenuWindow contains buttons that, when clicked, allow you to enter new values. This makes it easy to tweak values while your sketch is running, allowing you to make more user friendly Processing Sketches that people can interact with without having to edit any source code.
<br/>
<br/>
Included in the source code is an example to show you how the menu can be implemented. This should also serve as a good example of using multiple windows for one Processing sketch.
<br/>
<br/>
The Processing IDE is lightweight, but it has some limitations that make it difficult to utilize some of the object-oriented design features that Java allows. You should be able to get this code working in the Processing IDE, but I recommend using <a href = "https://code.google.com/archive/p/proclipsing/"> Proclipsing </a>, a plugin for <a href = "https://eclipse.org/"> Eclipse </a> that allows you to create Processing sketches in a more robust IDE.
