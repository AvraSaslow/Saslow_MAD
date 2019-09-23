//
//  ViewController.swift
//  Lab1
//
//  Created by Avra Saslow on 9/10/19.
//  Copyright © 2019 Avra Saslow. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var ClueImage: UIImageView!
    @IBOutlet weak var FennImage: UIImageView!
    @IBOutlet weak var FennText: UITextView!
    
    @IBAction func CluesButton(_ sender: UIButton) {
        ClueImage.image = UIImage(named: "TreasureMap")
        FennText.isHidden = true
    }
    
    @IBAction func FennButton(_ sender: UIButton) {
        FennImage.image = UIImage(named: "FennForrest")
        FennText.isHidden = true
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

