export default function App() {
  return (
    <main className="page-shell">
      <section className="welcome-card" aria-labelledby="welcome-title">
        <p className="eyebrow">LOCAL WORKSPACE</p>
        <h1 id="welcome-title">Property Inspection</h1>
        <p className="intro">
          Your workspace for inspection requests, appointments, and reports.
        </p>
        <div className="status-row">
          <span className="status-dot" aria-hidden="true" />
          <span>Application is running locally</span>
        </div>
      </section>
    </main>
  );
}
