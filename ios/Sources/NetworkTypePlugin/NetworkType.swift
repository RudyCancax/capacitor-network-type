import Foundation

@objc public class NetworkType: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
