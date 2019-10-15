//
//  ViewController.swift
//  CommuteCalculator
//
//  Created by Avra Saslow on 10/15/19.
//  Copyright © 2019 Avra Saslow. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    
    @IBOutlet weak var updateCommuteTime: UILabel!
    @IBOutlet weak var updateGas: UILabel!
    @IBOutlet weak var commutingAmount: UITextField!
    @IBOutlet weak var calculateOutlet: UIButton!
    @IBAction func calculateAction(_ sender: Any) {
        updateMilesAndGas(month: false, bike: false, bus: false)
    }
    
    
    func updateMilesAndGas(month: Bool, bike: Bool, bus: Bool) {
        var commutingMiles:Float
        var avgSpeed:Float
        avgSpeed = 20
        var avgMPG:Float
        avgMPG = 24
        var commuteTime:Float!
        var gasNeeded:Float!
        //if commuting amount is empty or not
        if commutingAmount.text!.isEmpty {
            commutingMiles = 0.0
        }
        else{
            commutingMiles = Float(commutingAmount.text!)!
        }

        commuteTime = (commutingMiles/avgSpeed)*60
        gasNeeded = commutingMiles/avgMPG
        
        if commutingMiles > 80 {
            let alertController = UIAlertController(title: "Whoa!", message:
                "You should probably carpool!!", preferredStyle: .alert)
            alertController.addAction(UIAlertAction(title: "Dismiss", style: .default))
            
            self.present(alertController, animated: true, completion: nil)
        }
    
        
        //if we are calculating the whole month
        if month == false {
            //t = d/r in minutes
            updateCommuteTime.text = String(commuteTime) + " minutes"
            
            //gasNeeded.round(.up) //so they have more than needed
            updateGas.text = String( gasNeeded) + " gallons"
        }
        //if we are calculating one day
        else {
            
            var monthlyCommute:Float
            var monthlyGas:Float
            monthlyCommute = commuteTime * 20
            monthlyGas = gasNeeded * 20
            updateCommuteTime.text = String(monthlyCommute) + " minutes"
            updateGas.text = String(format: "%.0f", monthlyGas) + " gallons"
        }
        
        
        //Assume bike average speed is 10 miles/hour
        //Assume bus average speed is 12 miles/hour + 5 min wait each way
        
        var bikeCommute:Float
        bikeCommute = (commutingMiles/10) * 60
        if bike == true {
            updateCommuteTime.text = String(bikeCommute) + " minutes"
            updateGas.text = "0 gallons"
        }
        
        if month == false && bike == true {
            var monthlyBikeCommute:Float
            monthlyBikeCommute = (bikeCommute * 20)
            //t = d/r in minutes
            updateCommuteTime.text = String(monthlyBikeCommute) + " minutes"
        }
    
        var busCommute:Float
        busCommute = ((commutingMiles/12) * 60) + 10
        if bus == true {
            updateCommuteTime.text = String(busCommute) + " minutes"
            updateGas.text = "0 gallons"
        }
        
        if month == false && bus == true {
            var monthlyBusCommute:Float
            monthlyBusCommute = (busCommute * 20)
            //t = d/r in minutes
            updateCommuteTime.text = String(monthlyBusCommute) + " minutes"
        }
    }
    
    
    @IBOutlet weak var numGallons: UILabel!
    @IBAction func gallonsSlider(_ sender: UISlider) {
        let Gallons = sender.value
        numGallons.text = String(format: "%.0f", Gallons) + " gallons"
    }
    
    
    //function that calculates monthly stats
    @IBOutlet weak var monthlySwitch: UISwitch!
    func showMonthlyCommute() {
        if monthlySwitch.isOn && updateTransportation.selectedSegmentIndex == 0{
            updateMilesAndGas(month: true, bike: false, bus: false)
        }
        if monthlySwitch.isOn && updateTransportation.selectedSegmentIndex == 1{
            updateMilesAndGas(month: true, bike: true, bus: false)
        }
        if monthlySwitch.isOn && updateTransportation.selectedSegmentIndex == 2{
            updateMilesAndGas(month: true, bike: false, bus: true)
        }
        if !monthlySwitch.isOn && updateTransportation.selectedSegmentIndex == 0{
            updateMilesAndGas(month: false, bike: false, bus: false)
        }
        if !monthlySwitch.isOn && updateTransportation.selectedSegmentIndex == 1{
            updateMilesAndGas(month: false, bike: true, bus: false)
        }
        if !monthlySwitch.isOn && updateTransportation.selectedSegmentIndex == 2{
            updateMilesAndGas(month: false, bike: false, bus: true)
        }
        
    }
    //action that calls show monthly commute function
    @IBAction func changeMonthly(_ sender: Any) {
        showMonthlyCommute()
    }
    
    
    
    @IBOutlet weak var updateTransportation: UISegmentedControl!
    @IBOutlet weak var transportationImage: UIImageView!
    
    func updateImage(){
        if updateTransportation.selectedSegmentIndex == 0 {
            transportationImage.image=UIImage(named: "car_icon")
            updateMilesAndGas(month: false, bike: false, bus: false)
        }
        if updateTransportation.selectedSegmentIndex == 1 {
            transportationImage.image=UIImage(named: "bike_icon")
            updateMilesAndGas(month: false, bike: true, bus: false)
            
        }
        else if updateTransportation.selectedSegmentIndex == 2 {
            transportationImage.image=UIImage(named: "bus_icon")
            updateMilesAndGas(month: false, bike: true, bus: true)
        }
    }
    
    @IBAction func changeImage(_ sender: Any) {
        updateImage()
    }
    
    

    
    
    
    
    
    
    
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    
    
    
    override func viewDidLoad() {
        commutingAmount.delegate=self
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

