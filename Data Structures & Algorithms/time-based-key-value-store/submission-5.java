class TimeMap {
    Map<String, List<Pair<Integer, String>>> keyStore;
    //Map<String, List<String>> values;
    //[1, 2] 2
    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!this.keyStore.containsKey(key)) {
            this.keyStore.put(key, new ArrayList<>());
        }
        this.keyStore.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        //if timestamp not in tmps[key] -> return tmps[key][:-1]
        List<Pair<Integer, String>> values = keyStore.getOrDefault(key, new ArrayList<>());
        int left = 0, right = values.size() - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(values.get(mid).getKey() == timestamp) 
                return values.get(mid).getValue();
            else if(values.get(mid).getKey() < timestamp) left = mid + 1;
            else right = mid - 1;
        }

        return right >= 0 ? values.get(right).getValue() : "";
    }
}
