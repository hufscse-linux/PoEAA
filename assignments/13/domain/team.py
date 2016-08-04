class Team(object):
    def __init__(self, team_id, name, project_id, project):
        self.team_id = team_id
        self.name = name
        self.project_id = project_id
        self.project = project

    def __repr__(self):
        return "<Team(name= %s, projectId = %d) >" %(self.name, self.project_id)

