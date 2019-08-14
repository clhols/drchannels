import Foundation
import UIKit
import DrLogic

public class UI: Kotlinx_coroutines_coreCoroutineDispatcher {
    override public func dispatch(context: KotlinCoroutineContext, block: Kotlinx_coroutines_coreRunnable) {
        DispatchQueue.main.async {
            block.run()
        }
    }
}
