class TimeMap {
    Map<String, List<Pair<Integer, String>>> keyStore;
    //Map<String, List<String>> values;
    //[1, 2] 2
    public TimeMap() {
        keyStore = new HashMap<>();
        //values = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!this.keyStore.containsKey(key)) {
            this.keyStore.put(key, new ArrayList<>());
            //this.values.put(key, new ArrayList<>());
        }
        this.keyStore.get(key).add(new Pair<>(timestamp, value));
        //this.values.get(key).add(value);
    }
    
    public String get(String key, int timestamp) {
        //if timestamp not in tmps[key] -> return tmps[key][:-1]
        List<Pair<Integer, String>> values = keyStore.getOrDefault(key, new ArrayList<>());
        int left = 0, right = values.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (values.get(mid).getKey() <= timestamp) {
                result = values.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
