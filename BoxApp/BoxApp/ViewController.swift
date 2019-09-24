//
//  ViewController.swift
//  BoxApp
//
//  Created by Avra Saslow on 9/20/19.
//  Copyright © 2019 Avra Saslow. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var TypeOfBox: UISegmentedControl!
    @IBOutlet weak var BoxImage: UIImageView!
    @IBOutlet weak var titleLabel: UILabel!
    
    
    @IBAction func changeImage(_ sender: UISegmentedControl) {
        if TypeOfBox.selectedSegmentIndex == 0 {
            titleLabel.text = "cereal box"
            BoxImage.image=UIImage(named: "ricekrispies")
        }
        else if TypeOfBox.selectedSegmentIndex == 1 {
            titleLabel.text = "box turtle"
            BoxImage.image=UIImage(named: "turtle")
        }
    }
    

    @IBOutlet weak var capitalSwitch: UISwitch!
    @IBAction func updateFont(_ sender: UISwitch) {
        if capitalSwitch.isOn{
            titleLabel.text = titleLabel.text?.uppercased()
        }
        else {
            titleLabel.text = titleLabel.text?.lowercased()
        }
    }
    
    
    @IBOutlet weak var TextSizeLabel: UILabel!
    @IBAction func changeFontSize(_ sender: UISlider) {
        let fontSize = sender.value
        TextSizeLabel.text=String(format: "%.0f", fontSize)
        let fontSizeCGFloat = CGFloat(fontSize)
        titleLabel.font = UIFont(name: "Cochin", size: fontSizeCGFloat)
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

