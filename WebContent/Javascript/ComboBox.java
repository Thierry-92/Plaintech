require([
  "dojo/store/Memory",
  "dojox/mobile/ComboBox"
], function(Memory, ComboBox){
  colorMemoryStore = new Memory({ idProperty: "name", data: [
    { name: "Red" },
    { name: "Blue" },
    { name: "Yellow" }
  ]});
});