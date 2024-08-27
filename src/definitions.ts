export interface NetworkTypePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
