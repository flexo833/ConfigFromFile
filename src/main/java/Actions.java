
public interface Actions {


     enum Action {
        openUrl("openUrl"),
        Click("Click"),
        SetValue("SetValue"),
        Screenshot("Screenshot"),
        ClickEnter("ClickEnter");


        private String action;

        Action(String action) {
            this.action = action;
        }

        public String getAction() {
            return action;
        }

    }


}
