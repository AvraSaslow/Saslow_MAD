//
//  ViewController.swift
//  NewRoots
//
//  Created by Avra Saslow on 10/7/19.
//  Copyright © 2019 Avra Saslow. All rights reserved.
//

import UIKit
import MessageUI

class ViewController: UIViewController, MFMailComposeViewControllerDelegate, UITextFieldDelegate {
    
    //alert
    @IBAction func showAlert(_ sender: Any) {
        let alertController = UIAlertController(title: "Form Requirements.", message:
            "You must have the mail app downloaded with your email already synced to submit this form. One order is a single item of the vegetable.", preferredStyle: .alert)
        alertController.addAction(UIAlertAction(title: "Dismiss", style: .default))
        
        self.present(alertController, animated: true, completion: nil)
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        customerName.delegate=self
        customerEmail.delegate=self
    }
    
  
    @IBOutlet weak var customerName: UITextField!
    @IBOutlet weak var customerEmail: UITextField!
    @IBOutlet weak var priceLabel: UILabel!
    @IBOutlet weak var cabbageStepper: UIStepper!
    @IBOutlet weak var eggplantStepper: UIStepper!
    @IBOutlet weak var broccoliStepper: UIStepper!
    @IBOutlet weak var cabbageLabel: UILabel!
    @IBOutlet weak var eggplantLabel: UILabel!
    @IBOutlet weak var broccoliLabel: UILabel!
    
    
    @IBAction func updateCabbage(_ sender: Any) {
        if cabbageStepper.value == 1 {
            cabbageLabel.text = "1 order"
        }
        else {
            cabbageLabel.text = String(format: "%.0f", cabbageStepper.value) + " orders"
        }
    }
    
    @IBAction func updateEggplant(_ sender: Any) {
        if eggplantStepper.value == 1 {
            eggplantLabel.text = "1 order"
        }
        else {
            eggplantLabel.text = String(format: "%.0f", eggplantStepper.value) + " orders"
        }
    }
    
    @IBAction func updateBroccoli(_ sender: Any) {
        if broccoliStepper.value == 1 {
            broccoliLabel.text = "1 order"
        }
        else {
            broccoliLabel.text = String(format: "%.0f", broccoliStepper.value) + " orders"
        }
    }
    
   func updateTotalPrice(){
    let broccoliOrder = broccoliStepper.value
    let cabbageOrder = cabbageStepper.value
    let eggplantOrder = eggplantStepper.value
    
    var cabbagePrice : Float = 2.75
    var totalCabbage : Float = Float(cabbageOrder) * cabbagePrice
    
    var eggplantPrice : Float = 3.45
    var totalEggplant : Float = Float(eggplantOrder) * eggplantPrice
    
    var broccoliPrice : Float = 1.95
    var totalBroccoli : Float = Float(broccoliOrder) * broccoliPrice
    var Total : Float = totalCabbage + totalEggplant + totalBroccoli
    
    priceLabel.text = "$" + String(Total);
    }
    
    @IBAction func cabbageUpdatePrice(_ sender: Any) {
        updateTotalPrice()
    }
    
    @IBAction func eggplantUpdatePrice(_ sender: Any) {
        updateTotalPrice()
    }
    
    @IBAction func broccoliUpdatePrice(_ sender: Any) {
        updateTotalPrice()
    }
    
    
        
        
    //MARK: IBAction Method for Button click
    @IBAction func sendEmail(_ sender: Any) {
        
        //get customer name
        let price: String = priceLabel.text!
        let cabbageText: String = cabbageLabel.text!
        let eggplantText: String = eggplantLabel.text!
        let broccoliText: String = broccoliLabel.text!
        let name: String = customerName.text!
        let email: String = customerEmail.text!
        //let tomato: String = tomato
        //get today's date
        let dateFormatter : DateFormatter = DateFormatter()
        dateFormatter.dateFormat = "MMM-dd-yy"
        let date = Date()
        let dateString = dateFormatter.string(from: date)
        
        
        //send email
        if MFMailComposeViewController.canSendMail() {
            let mail = MFMailComposeViewController()
            mail.mailComposeDelegate = self
            mail.setToRecipients(["newrootsfarmllc@gmail.com", email])
            mail.setSubject("CSA Order Form for \(name) on \(dateString)")
            //include date above
            mail.setMessageBody("<p>Hi Sarah! <br/> Here is my order for the upcoming week: <br/> I want \(cabbageText) of cabbage, \(eggplantText) of eggplant, and \(broccoliText) of broccoli. <br/>The total price is: \(price) <br/> Thank you! -\(name)</p>", isHTML: true)
            present(mail, animated: true)
        } else {
            print("Application is not able to send an email")
        }
    }
    
    //MARK: MFMail Compose ViewController Delegate method
    func mailComposeController(_ controller: MFMailComposeViewController, didFinishWith result: MFMailComposeResult, error: Error?) {
        controller.dismiss(animated: true)
    }
}



