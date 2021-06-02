## Accessibility Testing <br> 
### Accessibility Testing is defined as a type of Software Testing performed to ensure that the application being tested is usable by people with disabilities like hearing, color blindness, old age and other disadvantaged groups. It is a subset of Usability Testing.<br> 
Click this link to view <a href="https://www.w3.org/TR/UNDERSTANDING-WCAG20/Overview.html#contents" title="Click here to view WCAG Official Website">*WCAG Official Website* </a><br>
## How many total WCAG success criteria are there?<br> 
There are a total of <b>61 </b>WCAG 2.0 success criteria, and a total of <b>78</b> WCAG 2.1 success criteria (not including conformance criteria). WCAG 2.0 is a subset of WCAG 2.1, meaning that all 61 WCAG 2.0 guidelines are a part of WCAG 2.1. WCAG 2.1 adds 17 new success criteria.<br>
### WCAG 2.0 Principles
The four guiding principles of WCAG 2.0 say that Web content must be Perceivable, Operable, Understandable and Robust (POUR) in order to be accessible to people with disabilities.
<details>
  <summary>Perceivable</summary>    
:fleur_de_lis: Information and user interface components must be presentable to users in ways they can perceive.
<p>This means that users must be able to perceive the information being presented (it can't be invisible to all of their senses)</p>
</details>
<details>
  <summary>Operable</summary>   
 :fleur_de_lis: User interface components and navigation must be operable.
<p>This means that users must be able to operate the interface (the interface cannot require interaction that a user cannot perform)</p>
</details>
<details>
  <summary>Understandable</summary>  
 :fleur_de_lis: Information and the operation of user interface must be understandable
<p>This means that users must be able to understand the information as well as the operation of the user interface (the content or operation cannot be beyond their understanding)</p>
</details>
<details>
  <summary>Robust</summary> 
  :fleur_de_lis: Content must be robust enough that it can be interpreted reliably by a wide variety of user agents, including assistive technologies.
<p>This means that users must be able to access the content as technologies advance (as technologies and user agents evolve, the content should remain accessible)</p>
</details>

:+1: <a href="https://www.youtube.com/watch?v=-v4LyAH4xmg" title="Click here to know What is Accessibility Testing">*What is Accessibility Testing* </a><br>
:+1: Click this link to view <a href="https://youtube.com/playlist?list=PLXLyB_RNO9mAfETLhJsTaSEiL8vmoBsQe" title="Click here to view YouTube Tutorial">*Tutorial* </a><br>
:+1: <a href="https://www.youtube.com/watch?v=x8ST9a-eSFg" title="Click here to view Automate using Selenium WebDriver">*Automate using Selenium WebDriver* </a><br>
:+1: <a href="https://www.youtube.com/watch?v=f_pW2EpwqG8" title="Click here to view Accessibility Testing using AXE Tool">*Accessibility Testing using AXE Tool* </a><br>
:+1: <a href="https://www.youtube.com/watch?v=RjpvOqZigao" title="Understanding Accessibility: WCAG’s 13 Guidelines">*Understanding Accessibility: WCAG’s 13 Guidelines* </a><br>
:+1: <a href="https://www.youtube.com/watch?v=6V0zl-pSCSs" title="Click here to view What's the difference between WCAG Levels A and AA?">*What's the difference between WCAG Levels A and AA?* </a><br>
:+1: <a href="https://www.youtube.com/watch?v=f5qv7AnTUHk" title="Click here to view What’s new in WCAG 2.1?">*What’s new in WCAG 2.1?* </a><br>
:+1: <a href="https://www.youtube.com/watch?v=0hqhAIjE_8I" title="Click here to view What is ARIA & Why it's Important to Use!">*What is ARIA & Why it's Important to Use!* </a><br>
## Web Accessibility Testing Checklist
View [`Manuel Testing Checklist`](https://github.com/venkywarriors/Generic-functions-Selenium-java/blob/master/Accessibility-Testing-Checklist3.pdf):clipboard:<br>
View [`a11y Checklist`](https://www.a11yproject.com/checklist/):spiral_notepad:<br>
### :pushpin: Keyboard only operation
- [x] Check focus (tab) order
- [x]  check visual indication of keyboard focus (make more visual)
- [x] any keyboard traps?
- [x] does any hidden content get focus?
- [x] does anything which is mous-operable not get keyboard focus?
- [x] are there any custom controls or widgets which cannot be operated with keyboard-only use?
### :pushpin: Activate Assistive Tech
- [x] activate the AT you are testing with before opening the program or browser
- [x] Open the program or the browser and website you are testing
  - IE11/JAWS
  - NVDA/Firefox (pre quantum updates)
  - VoiceOver/Safari
- [x] Use the AT to access the feature or page to be tested
  - try not to use the mouse - no errors, but bad testing habits
### :pushpin: Visual Testing with a screen reader
- [x] Using JAWS on a webpage in IE11
  - use down arrow key to read through the page
  - order matches visual order
  - anything skipped
  - anything read which isn't visible
- [x] Use tab key and shift- [x]tab to read through the page
  - only controls receive focus
  - anything skipped
  - can every link button and custom control be operated
  - does the announced role match the result
  - does a link go somewhere or does it open a dialog
- [x] Shortcuts
  - Insert-F6 to see struct of headings
  - Insert-F7 to see a list of links (check for meaning in context or in list)
  - 'L' key to see order of lists
  - 'F' key to see order from form fields (Insert-F5)
  - 'T' key to see order of tables 
### :pushpin: Image Testing
- [x] Inspect all images for "alt" attributes
  - if no alt, usually will read file name
- [x] which images are purely decorative
  - remove colors (IE a11y tools) - is the message being indicated by color alone? (red for error)
  - determine if color is an indicator
- [x] both colorblind and screenreader
- [x] looking at the page is info indicated with styling (bold italic shading etc)
### :pushpin: Font and background color testing
- [x] change text and background colors in browser, is everything that is informative still visible?
  - test high contrast modes
- [x] Exit responsive design view, reduce size to default and activate color contrast checker (level access tool)
### :pushpin: Enlarging Text
- [x] Increase size to 200% open responsive design view (ctrl-shift-m in firefox), and sclae down to 1366x768 (most common screen size)
- [x] Does text wrap properly
- [x] wcag requires up to 200% ******
- [x] is any feature lost / hidden?
- [x] does text blur as it's larger? - possibly yes bc it's an image and not actual text
### :pushpin: CSS Testing
Testing the Information provided and the CSS relationship
- [x] Remove CSS
  - in firefox go to view > page style > no style to remove css
  - view dom order on screen
### :pushpin: Visual Aria Testing
- [x] If the product uses ARIA
  - Use the visual ARIA bookmarklet
- [x] Tab through all custom widgets, open menus, etc
- [x] Example Normal view vs Example ARIA bookmarklet view
### :pushpin: Automated Testing
- [x] run automated web accessibility tests, using one of the number of different tools
- [x] cross-references those results with the ones from manual testing
- [x] remove duplication and check for false positives 
