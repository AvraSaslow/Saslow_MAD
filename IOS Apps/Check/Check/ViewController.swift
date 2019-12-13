//
//  ViewController.swift
//  Check
//
//  Created by Avra Saslow on 9/26/19.
//  Copyright © 2019 Avra Saslow. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    @IBOutlet weak var checkAmount: UITextField!
    @IBOutlet weak var tipPercent: UITextField!
    @IBOutlet weak var peopleLabel: UILabel!
    @IBOutlet weak var peopleStepper: UIStepper!
    @IBOutlet weak var tipDue: UILabel!
    @IBOutlet weak var totalDue: UILabel!
    @IBOutlet weak var totalDuePerPerson: UILabel!
    
    func updateTipTotals(){
        var amount:Float
        var pct:Float
        //if check amount is empty or not
        if checkAmount.text!.isEmpty {
            amount = 0.0
        } else{
            amount = Float(checkAmount.text!)!
        }
        //if tip percent is empty or not, also /100
        if tipPercent.text!.isEmpty {
            pct = 0.0
        } else{
            pct = Float(tipPercent.text!)!/100
        }
        
        let numberOfPeople = peopleStepper.value
        let tip = amount*pct
        let total = amount+tip
        var personTotal : Float = 0.0
        if numberOfPeople > 0 {
            personTotal = total/Float(numberOfPeople)
        }
        //currency formatter
        let currencyFormatter = NumberFormatter()
        currencyFormatter.numberStyle=NumberFormatter.Style.currency
        tipDue.text = currencyFormatter.string(from: NSNumber(value:tip))
        totalDuePerPerson.text = currencyFormatter.string(from: NSNumber(value:personTotal))
        totalDue.text = currencyFormatter.string(from: NSNumber(value: total))
        
    }
    
    @IBAction func updatePeople(_ sender: Any) {
        if peopleStepper.value == 1 {
            peopleLabel.text = "1 person"
        }
        else {
            peopleLabel.text = String(format: "%.0f", peopleStepper.value) + " people"
        }
        updateTipTotals()
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    override func viewDidLoad() {
        checkAmount.delegate=self
        tipPercent.delegate=self
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

