package com.example.dwellings

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.PI
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myHouse = SquareCabin(6, 50.0)
        val myHut = RoundHut(1, 10.0)
        val myTower = RoundTower(4, 2, 15.5)
        val myDwellings = arrayOf(myHouse, myHut, myTower)
        val numGuestsText: TextView = findViewById(R.id.numGuestsBookingText)
        var numGuestsBooking = numGuestsText.text.toString().toInt()
        var currentDwelling: Dwelling = myHouse
        updateDwelling(currentDwelling, numGuestsBooking)

        // set button listeners
        val nextDwellingButton: Button = findViewById(R.id.nextDwellingButton)
        val previousDwellingButton: Button = findViewById(R.id.previousDwellingButton)
        val selectDwellingButton: Button = findViewById(R.id.selectDwellingButton)
        nextDwellingButton.setOnClickListener {
            currentDwelling = buttonClick(currentDwelling, myDwellings, "next")
        }
        previousDwellingButton.setOnClickListener {
            currentDwelling = buttonClick(currentDwelling, myDwellings, "previous")
        }
        selectDwellingButton.setOnClickListener { buttonClick(currentDwelling, myDwellings, "reserve") }

    }

    /**
     * update dwelling image and text fields
     * arg = string of action to take: next, previous, select
     */
    fun buttonClick(
        currentDwelling: Dwelling,
        myDwellings: Array<Dwelling>,
        whichAction: String
    ): Dwelling {
        // need to initialize newDwelling so just throw in an unreal value b/c
        // it'll be updated if it gets returned
        val numGuestsBookingView: TextView = findViewById(R.id.numGuestsBookingText)
        val numGuestsBooking = numGuestsBookingView.text.toString().toInt()
        var newDwelling = currentDwelling
        var dwellingIndex: Int
        // TODO: once I learn about data structures change from a hardcoded progression
        // iterate +/- 1 through data structure will be a lot easier and shorter
        when (whichAction) {
            "next" -> {
                dwellingIndex = myDwellings.indexOf(currentDwelling)
                if (dwellingIndex == myDwellings.size-1) { dwellingIndex = 0 }
                else { dwellingIndex++ }
                newDwelling = myDwellings[dwellingIndex]
            }
            "previous" -> {
                dwellingIndex = myDwellings.indexOf(currentDwelling)
                if (dwellingIndex == 0) { dwellingIndex = myDwellings.size-1 }
                else { dwellingIndex-- }
                newDwelling = myDwellings[dwellingIndex]
            }
            // whichAction == select
            else -> {
                newDwelling.getRoom(newDwelling,numGuestsBooking)
            }
        }

        updateDwelling(newDwelling, numGuestsBooking)

        return newDwelling
    }

    private fun updateDwelling(newDwelling: Dwelling, numGuestsBooking: Int) {
        // assign all the Views to update
        val residentLabel: TextView = findViewById(R.id.numResidentsText)
        val dwellingLabel: TextView = findViewById(R.id.dwellingLabel)
        val numFloorsText: TextView = findViewById(R.id.numFloorsText)
        val floorAreaText: TextView = findViewById(R.id.floorAreaText)
        val capacityText: TextView = findViewById(R.id.capacityText)
        val buildingMaterialText: TextView = findViewById(R.id.buildingMaterialText)
        val hasRoomTextArea: TextView = findViewById(R.id.hasRoomTextArea)
        val dwellingImage: ImageView = findViewById(R.id.dwellingImage)

        residentLabel.text = newDwelling.numRes().toString()
        dwellingLabel.text = newDwelling.name
        numFloorsText.text = newDwelling.floors.toString()
        floorAreaText.text = String.format("%.2f", newDwelling.floorArea())
        capacityText.text = newDwelling.capacity.toString()
        buildingMaterialText.text = newDwelling.buildingMaterial
        hasRoomTextArea.text = newDwelling.getRoom(newDwelling,numGuestsBooking)
        // not really a space for this but part of the codelab
        // also doesn't work b/c class Dwelling doesn't have abstract fun
        // would have to be called specifically from roundhut or roundtower
        //if (newDwelling.name != "Square Cabin") {
        //    newDwelling.calculateMaxCarpetSize()
        //}
    }
}

/**
 * abstract class can't be instantiated b/c it doesn't have everything needed
 * it's like a sketch, not full details but like an outline
 *
 * private modifier on arg residents to change visibility so residents
 * can only be used w/in this class
 * https://kotlinlang.org/docs/visibility-modifiers.html#classes-and-interfaces
 */
abstract class Dwelling(private var residents: Int) {
    // can't give a pre-determined buildMaterial b/c unknown for a given building
    // abstract promises we'll address the value when an instance is constructed
    abstract val name: String
    abstract val buildingMaterial: String
    abstract val capacity: Int
    abstract val floors: Int

    fun hasRoom(numGuestsBooking: Int): Boolean {
        return (residents+numGuestsBooking) <= capacity
    }

    fun numRes(): Int {
        return residents
    }

    fun getRoom(newDwelling: Dwelling,numGuestsBooking: Int): String {
        if (hasRoom(numGuestsBooking)) {
            return "${newDwelling.name} has room"
        }
        else {
            return "${newDwelling.name} does not have room"
        }
    }

    // abstract function same was as abstract val
    // will be defined in subclasses
    abstract fun floorArea(): Double
}

/**
 * indicate inheritance w/ : InheritedClass
 */
class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    // override val says we're adjusting the abstract property from the inherited class
    override val name = "Square Cabin"
    override val buildingMaterial = "wood"
    override val capacity = 8
    override val floors = 1

    override fun floorArea(): Double {
        return length * length
    }
}

/**
 * make the class open so that it can be inherited by another class
 * by default classes are defined as final meaning they can't be inherited
 */
open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val name = "Round Hut"
    override val buildingMaterial = "straw"
    override val capacity = 2
    override val floors = 1

    override fun floorArea(): Double {
        return PI * radius * radius
    }

    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

/**
 * two arguments are allowed b/c it can extend the parent, it just can't have fewer
 * add = 2 to the arg in case there is not one passed in. 2 will default or be overridden
 * with the value passed in
 */
class RoundTower(residents: Int, override val floors: Int, radius: Double) :
    RoundHut(residents, radius) {
    override val name = "Round Tower"
    override val buildingMaterial = "stone"
    override val capacity = 4 * floors

    /**
     * user super.floorArea() to call the floorArea() fun
     * from the parent class
     */
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}