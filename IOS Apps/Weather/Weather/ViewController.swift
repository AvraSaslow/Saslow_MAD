//
//  ViewController.swift
//  Weather
//
//  Created by Avra Saslow on 10/2/19.
//  Copyright © 2019 Avra Saslow. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate{

    
    @IBOutlet weak var jacketStepper: UIStepper!
    @IBOutlet weak var jacketLabel: UILabel!
    @IBOutlet weak var temperature: UITextField!
    @IBOutlet weak var messageLabel: UILabel!
    @IBOutlet weak var numLabel: UILabel!
    @IBOutlet weak var celcius: UILabel!
    
   
    
    @IBAction func showAlert(_ sender: Any) {
        let alertController = UIAlertController(title: "Count any of the following:", message:
            "A vest, a parka, a shell, blazer, poncho, trench coat, raincoat, puffy, fleece", preferredStyle: .alert)
        alertController.addAction(UIAlertAction(title: "Dismiss", style: .default))
        
        self.present(alertController, animated: true, completion: nil)
    }
    
    
    func updateCelcius(){
        var temp: Float
        temp = Float(temperature.text!)!
        var cel: Float
        cel = (temp - 32) * (5/9)
        celcius.text = String(cel)
    }
            
    @IBAction func updateJacket(_ sender: Any) {
        
        updateCelcius()
        
        if jacketStepper.value == 1 {
            numLabel.text = "1 jacket"
        }
        else {
            numLabel.text = String(format: "%.0f", jacketStepper.value) + " jackets"
        }
        
        var temp:Float
        if temperature.text!.isEmpty {
            temp = 0.0
        } else{
            temp = Float(temperature.text!)!
        }
        
        if (jacketStepper.value > 3) || (temp > 80){
            messageLabel.text = "You'll be much too hot!"
        }
        
        else {
            messageLabel.text = "You should be an okay temperature!"
        }
    }
    
   
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    override func viewDidLoad() {
        temperature.delegate=self
        
        let tap = UITapGestureRecognizer(target: self.view,
                                         action: #selector(UIView.endEditing))
        view.addGestureRecognizer(tap)
        
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

