// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "NetworkType",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "NetworkType",
            targets: ["NetworkTypePlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "NetworkTypePlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/NetworkTypePlugin"),
        .testTarget(
            name: "NetworkTypePluginTests",
            dependencies: ["NetworkTypePlugin"],
            path: "ios/Tests/NetworkTypePluginTests")
    ]
)