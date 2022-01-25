## [Android Google codelab examples](https://developer.android.com/courses/android-basics-kotlin/unit-1) | [Markdown syntax guide](https://guides.github.com/features/mastering-markdown/)

### Happy Birthday
First codelab app. Static TextViews and ImageViews (one centered and one background).

**Files I've edited**
- [layout](https://github.com/BuiltByMeT/android-codelabs/tree/main/unit-1/android-happy-birthday/app/src/main/res/layout)
- [kotlin file](https://github.com/BuiltByMeT/android-codelabs/blob/main/unit-1/android-happy-birthday/app/src/main/java/com/example/happybirthday)
- [drawables](https://github.com/BuiltByMeT/android-codelabs/tree/main/unit-1/android-happy-birthday/app/src/main/res/drawable)
- [strings](https://github.com/BuiltByMeT/android-codelabs/blob/main/unit-1/android-happy-birthday/app/src/main/res/values/strings.xml)

**Key Skills**
- TextView
- ImageView
- reference strings.xml rather than hard coding text
-----------------
### Dice Roller
Second codelab app. Roll two dice with two buttons and display a text version of the results.

**Files I've edited**
- [layout](https://github.com/BuiltByMeT/android-codelabs/tree/main/unit-1/android-dice-roller/app/src/main/res/layout)
- [kotlin file](https://github.com/BuiltByMeT/android-codelabs/tree/main/unit-1/android-dice-roller/app/src/main/java/com/example/diceroller)
- [strings](https://github.com/BuiltByMeT/android-codelabs/blob/main/unit-1/android-dice-roller/app/src/main/res/values/strings.xml)

**Key Skills**
- findViewById(R.id.[viewId])
- setOnClickListener
- update TextView on user action
- syntax to call functions and return values

-----------------
### Lucky Dice Roller
Third codelab app. Basically Dice Roller but add in a lucky number to tell if you win. Utilizes ImageView rather than TextView for the results.

**Files I've edited**
- [layout](https://github.com/BuiltByMeT/android-codelabs/tree/main/unit-1/lucky-dice-roller/app/src/main/res/layout)
- [kotlin file](https://github.com/BuiltByMeT/android-codelabs/tree/main/unit-1/lucky-dice-roller/app/src/main/java/com/example/luckydiceroller)
- [drawables](https://github.com/BuiltByMeT/android-codelabs/tree/main/unit-1/lucky-dice-roller/app/src/main/res/drawable)
- [strings](https://github.com/BuiltByMeT/android-codelabs/blob/main/unit-1/lucky-dice-roller/app/src/main/res/values/strings.xml)

**Extras Beyond Codelab**
- allow user input for the lucky number *[in progress](https://github.com/BuiltByMeT/android-codelabs/issues/2#issuecomment-955055364)*
- display a winning message if one of the dice rolls the lucky number

**Key Skills**
- setImageResource to update ImageView
- update contentDescription depending on functionality
- using when to simplify if else if else statements
- -> syntax within when
- last condition within a when must be else if returning a value (like setting a variable)

-----------------
### Lemonade
Unit 1 codelab project. Create an app that runs on states updated when an image is clicked. Proceed through picking a lemon, squeezing it, drinking the lemonade, and starting again. Having some issues with test .kt files provided, errors on an import to review. But I copied and pasted the tests into my project rather than clone the starter kit so that I could muscle memory the main kt.

**Files I've edited**
- [layout](https://github.com/BuiltByMeT/android-codelabs/tree/main/unit-1/android-lemonade/app/src/main/res/layout)
- [kotlin file](https://github.com/BuiltByMeT/android-codelabs/tree/main/unit-1/android-lemonade/app/src/main/java/com/example/lemonade)
- [drawables](https://github.com/BuiltByMeT/android-codelabs/tree/main/unit-1/android-lemonade/app/src/main/res/drawable)
- [strings](https://github.com/BuiltByMeT/android-codelabs/blob/main/unit-1/android-lemonade/app/src/main/res/values/strings.xml)

**Extras Beyond Codelab**
- TBD

**Key Skills**
- properly reference strings.xml from .kt
- update app states and save vales if app moved to background
- update UI based on user input (clicking image to move through states)
