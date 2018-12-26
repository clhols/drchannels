//
//  ChannelTableViewCell.swift
//  drapi-test
//
//  Created by Claus Holst on 24/12/2018.
//  Copyright © 2018 Claus Holst. All rights reserved.
//

import UIKit

class ChannelTableViewCell: UITableViewCell {
    //MARK: Properties
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var channelImageView: UIImageView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
