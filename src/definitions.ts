// export interface NetworkTypePlugin {
//   echo(options: { value: string }): Promise<{ value: string }>;
// }
export interface NetworkTypePlugin {
  getNetworkType(): Promise<{ networkType: string }>;
}
