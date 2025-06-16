@PostMapping("/debug")
public String debug(@RequestParam String input) {
    // ❌ Vulnerable: Logging untrusted input directly
    System.out.println("Debug input: " + input);

    // ❌ Simulated command injection (educational only)
    try {
        String cmd = "echo " + input;
        Process proc = Runtime.getRuntime().exec(cmd);
        proc.waitFor();
    } catch (Exception e) {
        return "Error: " + e.getMessage();
    }

    return "Command executed";
}
