import { Plugins } from '@capacitor/core';
import type { NetworkTypePlugin } from './definitions';

const { NetworkType } = Plugins;

export class NetworkTypeAndroid implements NetworkTypePlugin {
  async getNetworkType(): Promise<{ networkType: string }> {
    try {
      const { networkType } = await NetworkType.getNetworkType();
      return { networkType };
    } catch (error) {
      console.error('Failed to get network type:', error);
      return { networkType: 'Unknown' };
    }
  }
}