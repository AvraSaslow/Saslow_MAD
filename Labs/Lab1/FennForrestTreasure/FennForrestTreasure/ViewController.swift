//
//  ViewController.swift
//  FennForrestTreasure
//
//  Created by Avra Saslow on 9/3/19.
//  Copyright © 2019 Avra Saslow. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var FennImage: UIImageView!
    
    @IBAction func TreasureButton(_ sender: UIButton) {
        if sender.tag == 1{
            FennImage.image = UIImage(named: "TreasureMap")
        } else {
            FennImage.image = UIImage(named: "FennForrest" )
        }
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

